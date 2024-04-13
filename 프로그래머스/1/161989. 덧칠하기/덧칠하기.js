function solution(n, m, section) {
    
    var answer = 0;
    var painted = 0;
    for(var s of section) {
        if(painted < s) {
            answer++;
            painted = s+m-1;
        }
    }
    return answer;

}