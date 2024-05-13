function solution(board) {
    let cntO = 0
    let cntX = 0
    
    function count(player){
        let cnt = 0
        board.forEach((row) => {
            row.split('').forEach((a) => {
                if(a === player) cnt++
            })
        })
        
        return cnt
    }
    
    cntO = count('O')
    cntX = count('X')
    
    function isWin(player) {
        for (let i = 0; i < 3; i++) {
            if (board[i][0] === player && board[i][1] === player && board[i][2] === player) return true;
        }
        
        for (let i = 0; i < 3; i++) {
            if (board[0][i] === player && board[1][i] === player && board[2][i] === player) return true;
        }
        
        if (board[0][0] === player && board[1][1] === player && board[2][2] === player) return true;
        if (board[0][2] === player && board[1][1] === player && board[2][0] === player) return true;

        return false;
    }
    
    const isWinO = isWin('O')
    const isWinX = isWin('X')
    
    if(cntX > cntO){
        return 0
    } else {
        if(isWinO && isWinX) return 0
        if(isWinO && !isWinX){
            if(cntO !== cntX + 1) return 0
        }
        if(!isWinO && isWinX) {
            if(cntO !== cntX) return 0
        }
        if(!isWinO && !isWinX) {
            if(cntO > cntX + 1) return 0
        }
        
    }
    
    return 1
    
}