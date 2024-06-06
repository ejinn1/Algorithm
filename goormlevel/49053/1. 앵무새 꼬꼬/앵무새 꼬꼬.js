// Run by Node.js
const readline = require('readline');

function solution(arr){
	return arr.map((str) => {
		return [...str].filter((ch) => 'aeiouAEIOU'.indexOf(ch) !== -1).join('')
	})
	
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let lines = []
	let N = null
	for await (const line of rl) {
		lines.push(line)
		if(lines.length === 1){
			N = lines[0]
		}
		if(lines.length === parseInt(N) + 1){
			rl.close();
		}
	}
	
	let arr = lines.slice(1)
	let res = solution(arr)
	res.forEach((r)=> {
		if(r.length == 0){
			console.log('???')
		} else {
			console.log(r)
		}
	})
	
	process.exit();
})();
