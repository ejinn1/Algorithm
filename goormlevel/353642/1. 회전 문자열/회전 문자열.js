// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let num = null
	for await (const line of rl) {
		num = line
		rl.close();
	}
	
	const numArr = String(num).split("")
	numArr.reverse()

	const result = []
	for(let i=0 ; i<numArr.length ; i++){
		if(numArr[i] === '6'){
			numArr[i] = '9'
		} else if(numArr[i] === '9'){
			numArr[i] = '6'
		}
		result.push(numArr[i])
	}

	console.log(result.join(""))
	

	
	
	process.exit();
})();
