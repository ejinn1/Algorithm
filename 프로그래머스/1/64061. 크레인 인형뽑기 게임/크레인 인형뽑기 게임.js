function solution(board, moves) {
    const stack = []
    let result = 0
    
    moves.forEach((move) => {
        for(let i=0 ; i<board.length ; i++){
            if(board[i][move-1] !== 0){
                stack.push(board[i][move-1])
                board[i][move-1] = 0
                break
            }
        }
        
        if(stack.length > 1 && stack[stack.length-1] === stack[stack.length-2]){
            stack.pop()
            stack.pop()
            result += 2
        }
    })
    
    return result
}