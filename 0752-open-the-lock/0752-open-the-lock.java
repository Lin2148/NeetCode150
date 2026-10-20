class Solution {
    public int openLock(String[] deadends, String target) {
        int cnt = 0;
        // 放deadend、走過的、放進queue的(還沒走)
        Set<String> hs = new HashSet<>();
        for (String s : deadends){
            hs.add(s);
        }
        if (hs.contains("0000")){
            return -1;
        }

        //放可到達的 BFS用
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");


        while (!queue.isEmpty()){
            // 計算這一步 總共的點
            int size = queue.size();

            // 計算一層 全部點後 再把cnt+1
            for (int i = 0; i < size; i++){
                String reach = queue.poll();
                hs.add(reach);
                if (reach.equals(target)){
                    return cnt;
                } 

                //找reach可下一步走到的點
                char[] chs = reach.toCharArray();
                for (int j = 0; j < 4; j++){
                    char tmp = chs[j];
                    // +1
                    chs[j] =  (char) (tmp == '9' ? '0' : tmp + 1);
                    String next = String.valueOf(chs);
                    if (!hs.contains(next)){
                        queue.offer(next);
                        hs.add(next);
                    }
                    // -1
                    chs[j] =  (char) (tmp == '0' ? '9' : tmp - 1);
                    next = String.valueOf(chs);
                    if (!hs.contains(next)){
                        queue.offer(next);
                        hs.add(next);
                    }

                    // 該bit還原
                    chs[j] = tmp;
                }
            }
            cnt++;            
        }

        return -1;
    }
}