class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        if(coordinates.size() <= 2)
            return true;
        
        int x1 = coordinates[0][0];
        int x2 = coordinates[1][0];
        int y1 = coordinates[0][1];
        int y2 = coordinates[1][1];
        
        for(int i = 2; i < coordinates.size(); i++){
            int y3 = coordinates[i][1];
            int x3 = coordinates[i][0];
            
            if(((y2 - y1) * (x1 - x3)) != ((y1 - y3) * (x2 - x1))){
                return false;
            }       
        }
        return true; 
    }
    
};