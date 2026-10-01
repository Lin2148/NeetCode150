class unionFind{
    Map<String, String> parent;

    public unionFind(){
        parent = new HashMap<>();
    }

    public boolean union(String a, String b){
        String fA = find(a);
        String fB = find(b);
        
        if(fA.equals(fB)){
            return false;
        } else {
            parent.put(fB, fA);
            return true;
        }
    }

    public String find(String s){
        // 先放關係進去parent
        if (parent.get(s) == null){
            parent.put(s,s);
        }


        if (!parent.get(s).equals(s)){
            parent.put(s, find(parent.get(s)));
        }
        return parent.get(s);
    }

}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 先用string+路徑壓縮
        unionFind uf = new unionFind();
        // 遍歷完email後找回name
        Map<String, String> emailToName = new HashMap<>();
        
        // ans return
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> merge = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            emailToName.put(firstEmail, name);

            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                
                // first email連其他的
                uf.union(firstEmail, email);
            }
        }

        for (String email : emailToName.keySet()){
            String root = uf.find(email);
            if (!merge.containsKey(root)) {
                merge.put(root, new ArrayList<>());
            }
            merge.get(root).add(email);
        }
        
        for (List<String> email : merge.values()){
            Collections.sort(email);
            String name = emailToName.get(email.get(0));

            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(email);

            res.add(account);
        }
        return res;
    }
}