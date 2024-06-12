const readline = require('readline');
function solution(exp){
	const [a,b]=exp;
	console.log(Math.max(eval(a),eval(b)));
}
(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		solution(line.split(" "));
		rl.close();
	}
	
	process.exit();
})();