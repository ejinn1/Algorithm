// Run by Node.js
const readline = require('readline');
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

const input = [];

rl.on('line',(x)=>{
	input.push(x);
}).on('close',()=>{
	const N = +input[0];
	const stock = [];
	for(let i=1; i<N+1; i+=1){
		stock.push(input[i].split(' ').map(v=>+v));
	}
	solution(N, stock);
});

function solution(N, stock){
	const price = [];
	for(let i=0; i<stock.length; i+=1){
		const p = float(stock[i][0]*stock[i][1]);
		price.push({price:p,index:i+1})
	}
	
	const sortedPrice = [...price].sort((a,b)=>{
		if(b['price']===a['price']) return a['index']-b['index'];
		else return b['price']-a['price'];
	});
	let result = ''
	for(let i=0; i<N; i+=1){
		result += sortedPrice[i]['index']+' '
	}
	console.log(result)
}

function float(n){
	return Math.floor(n * 10) / 10;
}