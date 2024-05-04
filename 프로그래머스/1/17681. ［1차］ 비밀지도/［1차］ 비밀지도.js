function solution(n, arr1, arr2) {
    const result = []
    
    arr1 = arr1.map(a => a.toString(2).padStart(n, '0').split(''));
    arr2 = arr2.map(a => a.toString(2).padStart(n, '0').split(''));
    
    for(let i=0 ; i<n ; i++){
        let tmp = ""
        for(let j=0 ; j<n ; j++){
            if(arr1[i][j] === "1" || arr2[i][j] === "1"){
                tmp += "#"
            } else {
                tmp += " "
            }
        }
        result.push(tmp)
    }
    
    return result
}