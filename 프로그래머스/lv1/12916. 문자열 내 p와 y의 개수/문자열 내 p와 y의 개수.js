function solution(s){

    var p = s.toLowerCase().split('p').length
    var y = s.toLowerCase().split('y').length
    if(p === y){
        return true
    } else{
        return false
    }
    
}