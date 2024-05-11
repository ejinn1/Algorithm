function solution(numbers) {
    const n = numbers.length;
    const result = new Array(n).fill(-1);
    const stack = [];

    for (let i = n - 1; i >= 0; i--) {
        while (stack.length > 0 && stack[stack.length - 1] <= numbers[i]) {
            stack.pop();
        }
        if (stack.length > 0) {
            result[i] = stack[stack.length - 1];
        }
        stack.push(numbers[i]);
    }

    return result;
}
