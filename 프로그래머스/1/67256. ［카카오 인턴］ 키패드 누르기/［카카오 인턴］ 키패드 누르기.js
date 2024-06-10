function solution(numbers, hand) {
    const leftNumbers = [1,4,7]
    const rightNumbers = [3,6,9]
    const phone = [[3,1],[0,0],[0,1],[0,2],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2]]
    
    let left = [3,0]
    let right = [3,2]
    
    let res = [];
    let next
    let disL = 0
    let disR = 0
    
    for(let num of numbers){
        let key = phone[num]
        let op = ""
        
        if(rightNumbers.includes(num)){
            right = key
            op = "R"
        } else if(leftNumbers.includes(num)){
            left = key
            op = "L"
        } else {
            disL = Math.abs(left[0] - key[0]) + Math.abs(left[1] - key[1]);
            disR = Math.abs(right[0] - key[0]) + Math.abs(right[1] - key[1]);

            
            if(disL > disR){
                right = key
                op = "R"
            } else if(disL < disR){
                left = key
                op = "L"
            } else {
                if(hand === "right"){
                    right = key
                    op = "R"
                } else {
                    left = key
                    op = "L"
                }
            }
        }
        res.push(op)
    }
    
    return res.join('')
}