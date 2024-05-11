function solution(weights) {
    const countMap = new Map()
    let result = 0

    for(let weight of weights){
        if(countMap.has(weight)){
            countMap.set(weight, countMap.get(weight) + 1)
        } else {
            countMap.set(weight, 1)
        }
    }

    for(let [weight, count] of countMap){
        if(count > 1){
            result += (count * (count-1)) / 2
        }

        const factors = [2 / 3, 2 / 4, 3 / 4]
        for(let factor of factors){
            const target = weight * factor
            if(countMap.has(target)){
                result += count * countMap.get(target)
            }
        }
    }

    return result
}
