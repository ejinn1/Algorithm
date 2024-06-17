const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

function solution(n, m){
	const direction = [[1, 0], [-1, 0], [0, 1], [0, -1]]
	let visited = Array.from({length: n}, () => Array(n).fill(false))
	
	// function dfs(x, y){
	// 	if(m[x][y] === 0) return
	// 	for(let [dx, dy] of direction){
	// 		let cx = x + dx
	// 		let cy = y + dy
			
	// 		if(cx >= 0 && cx < n && cy >= 0 && cy < n && m[cx][cy] === 1 && !visited[cx][cy]){
	// 			visited[cx][cy] = true
	// 			dfs(cx, cy)
	// 		}
	// 	}
	// }
	
	let cnt = 0
	for(let i=0 ; i<n ; i++){
		for(let j=0 ; j<n ; j++){
			if(m[i][j] === 1 && !visited[i][j]){
				cnt++
				let queue = []
				queue.push([i, j])
				visited[i][j] = true
				
				while(queue.length > 0){
					let [x, y] = queue.shift()
					
					for(let [dx, dy] of direction){
						let cx = x + dx
						let cy = y + dy
						
						if(cx >= 0 && cx < n && cy >= 0 && cy < n && m[cx][cy] === 1 && !visited[cx][cy]){
							queue.push([cx, cy])
							visited[cx][cy] = true
						}
					}
				}	
			}
		}
	}
	console.log(cnt)
}
let input = []
let n = null
rl.on('line', (line) => {
	input.push(line)
	if(input.length === 1) n = parseInt(input[0])
	if(input.length === n+1) rl.close();
});

rl.on('close', () => {
	
	let m = input.slice(1).map((line) => line.split(' ').map(Number))
	
	solution(n, m)
})