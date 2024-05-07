function solution(babbling) {
    const list = ['aya', 'ye', 'woo', 'ma'];
    
    let result = 0;
    
    babbling.forEach((word) => {
        let valid = true;
        let lastUsed = "";

        while (word.length > 0 && valid) {
            let found = false;
            
            for (let l of list) {
                if (word.startsWith(l) && lastUsed !== l) {
                    word = word.slice(l.length);
                    lastUsed = l;
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                valid = false;
            }
        }

        if (valid && word.length === 0) {
            result++;
        }
    });
    
    return result;
}
