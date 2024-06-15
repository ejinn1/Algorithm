const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let input = []
let n = null
rl.on('line', (line) => {
	input.push(line)
	if(input.length === 1) n = Number(input[0])
	if(input.length === 2) rl.close();
});

rl.on('close', () => {
	let nums = input[1].split(' ').map(Number)
	let max = Math.max(...nums)
	let maxIdx = nums.indexOf(max)
	let front = nums.slice(0, maxIdx)
	let back = nums.slice(maxIdx)
	let sum = nums.reduce((acc, cur) => {
		return acc += cur
	}, 0)
	let valid = true;
  for (let i = 1; i <= maxIdx; i++) {
    if (nums[i] < nums[i - 1]) {
        valid = false;
        	break;
        }
    }

    for (let i = maxIdx + 1; i < n; i++) {
        if (nums[i] > nums[i - 1]) {
            valid = false;
            break;
        }
    }
		
	
	console.log(valid ? sum : 0)
})