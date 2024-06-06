// Run by Node.js
const readline = require('readline');

const pad = ["", ['1','.', ',', '?', '!'], ['2','A','B','C'],['3','D','E','F'],['4','G','H','I'],['5','J','K','L'],['6','M','N','O'],['7','P','Q','R','S'],['8','T','U','V'],['9','W','X','Y','Z']]

function solution(nums) {
	let res = "";
	let i = 0;
	while (i < nums.length) {
		let key = parseInt(nums[i]);
		let cnt = 0
		while (i + 1 < nums.length && nums[i + 1] === nums[i]) {
			cnt++;
			i++;
		}
		cnt %= pad[key].length;
		res += pad[key][cnt];
		i++;
  }
	console.log(res);
}


(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let lines = []
	for await (const line of rl) {
		lines.push(line)
		if(lines.length === 2){
			rl.close();
		}
	}
	
	let nums = lines[1]
	solution(nums)
	
	
	process.exit();
})();
