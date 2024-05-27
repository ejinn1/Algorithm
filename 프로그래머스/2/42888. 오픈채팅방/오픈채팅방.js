function solution(record) {
    // 무지 들어옴 => 프로도 들어옴
    // 프로도 들어옴 => 라이언 들어옴
    // 무지 나감 => 프로도 나감
    // 프로도 들어옴(무지 -> 프로도)
    // (프로도 -> 라이언)
    
    let user = new Map()
    record.forEach((re) => {
        const [op, id, name] = re.split(' ')
        if(op === "Enter" || op === "Change"){
            user.set(id, name)   
        }
    })
    
    let res = record.map((re) => {
        const [op, id, name] = re.split(' ')
        let option = ""
        if(op === "Enter"){
            option = "들어왔습니다."
        } else if(op === "Leave"){
            option = "나갔습니다."
        } else {
            return null
        }
        
        return `${user.get(id)}님이 ${option}`
    })
    
    return res.filter((r) => r !== null)
}