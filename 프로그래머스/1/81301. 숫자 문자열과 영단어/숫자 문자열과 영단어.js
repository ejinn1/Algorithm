function solution(s) {
    const numbers = [
  ['zero', '0'],
  ['one', '1'],
  ['two', '2'],
  ['three', '3'],
  ['four', '4'],
  ['five', '5'],
  ['six', '6'],
  ['seven', '7'],
  ['eight', '8'],
  ['nine', '9']
];

    numbers.forEach((num) => {
        const regex = new RegExp(num[0], 'g');
        s = s.replace(regex, num[1]);
    });
    
    return Number(s)
}