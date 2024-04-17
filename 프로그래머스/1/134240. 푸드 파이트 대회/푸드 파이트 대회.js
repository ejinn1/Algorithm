function solution(food) {
    
    
    const count = food.slice(0).map((f) => (Math.floor(f/2)))
    
    console.log(count)
    
    const left = []
    count.forEach((c, i) => {
        if(c !== 0){
            for(let j=0 ; j<c ; j++){
                left.push(i)
            }
        }
    })
    
    const result = [...left, 0, ...left.reverse()].join('')
    
    return result
}