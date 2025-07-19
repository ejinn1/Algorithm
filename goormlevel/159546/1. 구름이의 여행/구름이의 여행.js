// Run by Node.js
const readline = require('readline');

function solution(N, M, K, bridges) {
	const graph = Array.from({length: N+1}, () => [])
	for(let [u, v] of bridges){
		graph[u].push(v)
		graph[v].push(u)
	}

	const visited = Array(N+1).fill(-1)
	const queue = [[1, 0]]
	visited[1] = 0

	while(queue.length){
		const [node, dist] = queue.shift()
		for(let next of graph[node]){
			if(visited[next] === -1){
				visited[next] = dist + 1
				queue.push([next, dist + 1])
			}
		}
	}

	if(visited[N] !== -1 && visited[N] <= K){
		console.log("YES")
	} else {
		console.log("NO")
	}
	
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let N = null
	let M = null
	let K = null
	let lines = []
	for await (const line of rl) {
		lines.push(line)
		if(lines.length === 1){
			[N, M, K] = lines[0].split(" ").map(Number)
		}
		if(lines.length === M + 1) rl.close();
	}
	const bridges = lines.slice(1).map((b) => b.split(" ").map(Number))

	solution(N, M, K, bridges)
	
	process.exit();
})();
