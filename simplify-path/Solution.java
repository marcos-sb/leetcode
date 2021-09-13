class Solution {
    public String simplifyPath(String path) {
        final var separator = "/";
        final var folders = path.split(separator);
        final var canonical = new ArrayList<String>(folders.length);
        
        for (var f : folders) {
            if (f.isEmpty() || ".".equals(f)) continue;
            if ("..".equals(f)) {
                if (!canonical.isEmpty()) canonical.remove(canonical.size()-1);
                continue;
            }
            canonical.add(f);
        }
        
        return separator + String.join(separator, canonical);
    }
}
