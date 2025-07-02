class Solution {
    
    // 1. 오른쪽, 2.왼쪽
    static final int[] dcol = {1, -1}; 
    
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int col = w;
        int row = (int) Math.ceil ((double)n / w);
        
        int[][] map = new int[row][col];    
        
        int curNum = 0;
        int targetCol = 0;
        int targetRow = 0;
        int cnt = 0;
        
       for(int r=row-1; r>=0; r--){
           if(cnt % 2 == 0){
               for(int c=0; c<col && curNum < n; c++){
                   map[r][c] = ++curNum;
                   if(curNum == num)
                       targetCol = c;
               }
               cnt++;
           }else{
               for(int c=col-1; c>=0 && curNum < n; c--){
                   map[r][c] = ++curNum;
                   if(curNum == num)
                       targetCol = c;
               }
               cnt++;
           }
       }
                      
        // answer 구하기
        for(int r=0; r<=row-1; r++){
            if(map[r][targetCol] != 0)
                answer++;
            
            if(map[r][targetCol] == num)
                break;
        }
              
        return answer;
    }
}