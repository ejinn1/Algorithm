const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

function solution(n, k, m){
	let visited = Array.from({length: n}, () => Array(n).fill(false))
	let direction = [[1, 0], [-1, 0], [0, 1], [0, -1]]
	let score = {}
	
	for(let i=0 ; i<n ; i++){
		for(let j=0 ; j<n ; j++){
			if(!visited[i][j]){
				let q = []
				let count = 1
				q.push([i, j])
				let target = m[i][j]
				
				while(q.length > 0){
					let [x, y] = q.shift()
					visited[x][y] = true
					for(let [dx, dy] of direction){
						let cx = x + dx
						let cy = y + dy
						
						if(cx >= 0 && cx < n && cy >= 0 && cy < n && !visited[cx][cy] && m[cx][cy] === target){
							visited[cx][cy] = true
							count++
							q.push([cx, cy])
						}
					}
				}
				
				if(count >= k){
					score[target] = (score[target] || 0) + 1
				}
			}
		}
	}
	const sortedScores = Object.entries(score).sort((a, b) => b[1] - a[1] || b[0] - a[0])
	console.log(sortedScores.length ? sortedScores[0][0] : -1)
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
	
	let m = input.slice(1).map((line) => line.split(' ').map(Number))
	solution(n, k, m)

})