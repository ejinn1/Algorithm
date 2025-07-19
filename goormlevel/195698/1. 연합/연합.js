const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let N = null
let M = null
let lines = []
rl.on('line', (line) => {
	lines.push(line)
	if(lines.length === 1) {
		[N, M] = lines[0].split(" ").map(Number)
	}
	if(lines.length === M+1) rl.close();
});

rl.on('close', () => {
	const bridges = lines.slice(1).map((b) => b.split(" ").map(Number))
	
	const graph = Array.from({length: N+1}, () => [])
	const reGraph = Array.from({length: N+1}, () => [])
	for(let [u, v] of bridges){
		graph[u].push(v)
		reGraph[v].push(u)
	}

	const unGraph = Array.from({length: N+1}, () => [])
	for(let i=1 ; i<=N ; i++){
		for(const j of graph[i]){
			if(reGraph[i].includes(j)){
				unGraph[i].push(j)
			}
		}
	}

	const visited = Array(N+1).fill(false)
	let count = 0
	
	function dfs(node) {
	  visited[node] = true;
	  for (const next of unGraph[node]) {
	    if (!visited[next]) dfs(next);
	  }
	}
	
	for (let i = 1; i <= N; i++) {
	  if (!visited[i]) {
	    dfs(i);
	    count++;
	  }
	}
	console.log(count);

	
})