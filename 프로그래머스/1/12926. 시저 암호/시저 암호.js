function solution(s, n) {
    const result = s.split('').map((ch) => {
        if (ch >= 'A' && ch <= 'Z') {
            let offset = ch.charCodeAt() - 'A'.charCodeAt();
            let newChar = (offset + n) % 26;
            return String.fromCharCode('A'.charCodeAt() + newChar);
        } else if (ch >= 'a' && ch <= 'z') {
            let offset = ch.charCodeAt() - 'a'.charCodeAt();
            let newChar = (offset + n) % 26;
            return String.fromCharCode('a'.charCodeAt() + newChar);
        } else {
            return ch;
        }
    })
    
    return result.join('')
    
}