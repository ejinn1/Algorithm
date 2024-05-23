function solution(str1, str2) {
    str1 = str1.toLowerCase()
    str2 = str2.toLowerCase()
    
    function isChar(ch){
        return ch >= 'a' && ch <= 'z' ? true : false
    }
    
    function multiSet(str){
        let tmp = []
        for(let i=0 ; i<str.length ; i++){
            const one = str[i]
            const two = str[i+1]
            if(isChar(one) && isChar(two)){
                tmp.push(one+two)
            }
        }
        return tmp
    }
    
    const case1 = multiSet(str1)
    const case2 = multiSet(str2)
    
    function J(arr1, arr2){
        let inter = []
        let d = arr1.length + arr2.length
        
        for (let elem of arr1) {
            if (arr2.includes(elem)) {
                inter.push(elem)
                arr2.splice(arr2.indexOf(elem), 1)
            }
        }
        let n = inter.length
        d -= n
        if(d === 0) return 65536
        return Math.floor((n / d) * 65536)
    }
    
    return J(case1, case2)
}