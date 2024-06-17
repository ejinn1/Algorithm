const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

function solution(n, k, board){
	const direction = [[1,0], [-1,0], [0,1], [0,-1], [1,1], [1,-1],[-1,1],[-1,-1]]
	let flagCnt = 0
	for(let i=0 ; i<n ; i++){
		for(let j=0 ; j<n ; j++){
			if(board[i][j] === '0'){
				let cnt = 0
				for(let [dx, dy] of direction){
					let cx = i + dx
					let cy = j + dy
					if(cx >= 0 && cx < n && cy >= 0 && cy < n && board[cx][cy] === '1'){
						cnt++
					}
				}
				if(cnt === k){
					flagCnt++
				}
			}
		}
	}
	console.log(flagCnt)
}
let input = []
let n = null
let k = null
rl.on('line', (line) => {
	input.push(line)
	if(input.length === 1) [n, k] = input[0].split(' ').map(Number)
	if(input.length === n+1) rl.close();
});

rl.on('close', () => {
	let board = input.slice(1).map((line) => line.split(' '))
	
	solution(n, k, board)

})