const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let lines = []
rl.on('line', (line) => {
	lines.push(line)
	if(lines.length === 2){
		rl.close();	
	}
});

rl.on('close', () => {
	
	const N = lines[0]
	const nums = lines[1].split(" ").map(Number)
	const max = Math.max(...nums)
	
	let isUp = true
	let result = 0
	for(let i=0 ; i<nums.length-1; i++){
		if(nums[i] === max){
			isUp = false
		}
		if(isUp && nums[i] > nums[i+1]){
			result = 0
			break
		} else if(!isUp && nums[i] < nums[i+1]){
			result = 0
			break
		} else {
			result += nums[i]
		}
	}

	if(result !== 0 && nums.length !== 1){
		result += nums[nums.length - 1]
	} else if(nums.length === 1){
		result = nums[0]
	}

	console.log(result)
	
})