function solution(participant, completion) {
    var answer = '';
    
    participant = participant.sort()
    completion = completion.sort()
    
    console.log(participant)
    console.log(completion)
    
    for(let i=0 ; i<participant.length ; i++){
        if(participant[i] !== completion[i]){
            answer = participant[i]
            break
        }
    }
    
    return answer;
}