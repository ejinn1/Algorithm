function solution(cacheSize, cities) {
    let cache = []
    let total = 0
    
    if(cacheSize === 0) return cities.length * 5
    
    for(let city of cities){
        city = city.toLowerCase()
        if(cache.includes(city)){
            cache = cache.filter((c) => c !== city)
            cache.push(city)
            total += 1
        } else {
            if(cache.length < cacheSize){
                cache.push(city)
            } else {
                cache.shift()
                cache.push(city)
            }
            total += 5
        }
    }
    
    return total
}