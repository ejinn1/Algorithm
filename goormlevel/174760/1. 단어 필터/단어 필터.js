// Run by Node.js
const readline = require('readline');

function solution(rem, str) {
	while (str.includes(rem)) {
		str = str.replace(rem, '')
	}
	return str
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let lines = []
	for await (const line of rl) {
		lines.push(line)
		
		if(lines.length === 3){
			rl.close();
		}
	}
	
	let rem = lines[1]
	let str = lines[2]

	let res = solution(rem, str)
	if(res.length === 0){
		console.log("EMPTY")
	} else {
		console.log(res)
	}
	
	
	process.exit();
})();
