class Solution {
  public String performEditorActions(String[][] actions) {
    final StringBuilder sb = new StringBuilder();
    final Deque<String[]> actionsDone = new LinkedList<>();
    final Deque<String[]> actionsUndone = new LinkedList<>();
    for (String[] sArr : actions) {
      final String action = sArr[0];
      if (action.equals("INSERT")) {
        handleInsert(sArr, sb, actionsDone);
      } else if (action.equals("DELETE")) {
        handleDelete(sArr, sb, actionsDone);
      } else if (action.equals("UNDO")) {
        handleUndo(sb, actionsDone, actionsUndone);
      } else {
        handleRedo(sb, actionsDone, actionsUndone);
      }
    }

    return sb.toString();
  }
  
  private static void handleInsert(String[] insertAction, StringBuilder sb, Deque<String[]> actionsDone) {
    sb.append(insertAction[1]);
    actionsDone.offerLast(insertAction);
  }

  private static void handleDelete(String[] deleteAction, StringBuilder sb, Deque<String[]> actionsDone) {
    sb.setLength(sb.length()-1);
    actionsDone.offerLast(deleteAction);
  }

  private static void handleUndo(StringBuilder sb, Deque<String[]> actionsDone, Deque<String[]> actionsUndone) {
    if (actionsDone.isEmpty()) return;
    
    final String[] lastAction = actionsDone.pollLast();
    final String actionName = lastAction[0];
    if (actionName.equals("INSERT")) {
      sb.setLength(sb.length()-1);
    } else if (actionName.equals("DELETE")) {
      sb.append(lastAction[1]);
    }
    actionsUndone.offerLast(lastAction);
  }

  private static void handleRedo(StringBuilder sb, Deque<String[]> actionsDone, Deque<String[]> actionsUndone) {
    if (actionsUndone.isEmpty()) return;
    
    final String[] lastAction = actionsUndone.pollLast();
    final String actionName = lastAction[0];
    if (actionName.equals("INSERT")) {
      handleInsert(lastAction, sb, actionsDone);
    } else if (actionName.equals("DELETE")) {
      handleDelete(lastAction, sb, actionsDone);
    }
  }
}
