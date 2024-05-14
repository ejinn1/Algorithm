function solution(fees, records) {
    // fees 기본시간, 기본요금, 단위시간, 단위요금
    // records 시각, 번호, 출차
    
    let total = new Map()
    const tmp = new Map()
    
    records.forEach((record) => {
        let [time, number, type] = record.split(" ")
        time = time.split(":").map(Number)
        time = time[0]*60 + time[1]

        if(type === "IN"){
            tmp.set(number, time)
        } else {
            const parking = time - tmp.get(number)
            if(total.has(number)){
                total.set(number, total.get(number) + parking)
            } else {
                total.set(number, parking)
            }
            tmp.delete(number)
        }
    })

    for(let [number, time] of tmp.entries()){
        let lastTime = "23:59".split(":").map(Number)
        lastTime = lastTime[0]*60 + lastTime[1]
        const parking = lastTime - tmp.get(number)
            if(total.has(number)){
                total.set(number, total.get(number) + parking)
            } else {
                total.set(number, parking)
            }
            tmp.delete(number)
    }
    
    total = new Map([...total].sort((a, b) => a[0] - b[0]))
    
    const res = []
    for(let [number, parking] of total){
        let fee = fees[1]
        if(parking >= fees[0]){
            parking -= fees[0]
            fee += Math.ceil((parking / fees[2])) * fees[3]
        }
        res.push(fee)
    }
    
    return res
}