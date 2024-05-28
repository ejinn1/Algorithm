// Run by Node.js
const readline = require('readline');

function solution(n){
	let dp = Array.from({length:n}).fill(0)
	dp[1] = 1
	dp[2] = 1
	dp[3] = 2
	
	for(let i=4 ; i<=n ; i++){
		dp[i] = (dp[i-1] + dp[i-3]) % 1000000007
	}
	
	return dp[n]
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let data = ""
	for await (const line of rl) {
		data = line
		rl.close();
	}
	
	const res = solution(data)
	console.log(res)
	
	process.exit();
})();
