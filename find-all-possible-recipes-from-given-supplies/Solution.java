class Solution {
    private Map<String, List<String>> graph;
    private Set<String> supplySet;
    private Set<String> missing;
    private Set<String> open;
    
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        final var R = recipes.length;
        graph = new HashMap<>(R);
        final var S = supplies.length;
        supplySet = new HashSet<>(S);
        missing = new HashSet<>();
        open = new HashSet<>();
        for (var r : recipes) graph.put(r, new ArrayList<>());
        for (var i = 0; i < R; i++) {
            final var r = recipes[i];
            final var ingdts = ingredients.get(i);
            final var reqs = graph.get(r).addAll(ingdts);
        }
        for (var s : supplies) supplySet.add(s);
        final var res = new ArrayList<String>();
        for (var u : graph.keySet()) topological(u, res);
        return res;
    }

    private boolean topological(String u, List<String> res) {
        if (missing.contains(u) || open.contains(u)) return false;
        if (supplySet.contains(u)) return true;
        if (!graph.containsKey(u)) {
            missing.add(u);
            return false;
        }
        open.add(u);
        for (var v : graph.get(u))
            if (!topological(v, res)) {
                missing.add(u);
                return false;
            }
        open.remove(u);
        supplySet.add(u);
        res.add(u);
        return true;
    }
}
