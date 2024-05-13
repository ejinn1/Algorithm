function solution(storey) {
    const st = storey.toString().split('').map(Number).reverse()
    st.push(0)
    let result = 0
    for(let i=0 ; i < st.length ; i++){
        console.log(st)
        if(st[i] > 5 || (st[i] === 5 && st[i + 1] >= 5)){
            let j = i+1
            while(j < st.length){
                if(st[j] === 9){
                    st[j] = 0
                    j++
                } else {
                    st[j] += 1
                    break
                }
            }
            result += (10 - st[i])
            st[i] = 0
        } else {
            result += st[i]
            st[i] = 0
        }
        console.log(result)
    }
    
    
    return result
}