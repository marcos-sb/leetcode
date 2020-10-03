class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        final Map<String,Map<String,Double>> eqs = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            final var eq = equations.get(i);
            final var val = values[i];
            eqs.computeIfAbsent(eq.get(0), s -> new HashMap<>());
            eqs.computeIfAbsent(eq.get(1), s -> new HashMap<>());
            eqs.get(eq.get(0)).putIfAbsent(eq.get(1), val);
            eqs.get(eq.get(1)).putIfAbsent(eq.get(0), 1/val);
        }

        final var ret = new double[queries.size()];
        var i = 0;
        for (var q : queries) {
            final var val = calculateValue(q.get(0), q.get(1), eqs, new HashSet<>());
            ret[i++] = val != null ? val : -1;
        }

        return ret;
    }

    private static Double calculateValue(String q0, String q1, Map<String,Map<String,Double>> eqs, Set<String> open) {
        if (!eqs.containsKey(q0) || !eqs.containsKey(q1)) return null;
        final var q0Map = eqs.get(q0);

        if (q0Map.containsKey(q1)) return q0Map.get(q1);

        String newq0 = null;
        Double val = null;
        for (var q0e : q0Map.entrySet()) {
            newq0 = q0e.getKey();
            if (open.contains(newq0)) continue;
            else open.add(newq0);
            val = calculateValue(newq0, q1, eqs, open);
            if (val != null) break;
        }
        if (val == null) return null;

        final var newVal = val * q0Map.get(newq0);
        q0Map.put(q1, newVal);
        eqs.get(q1).put(q0, 1/newVal);
        return newVal;
    }
}
