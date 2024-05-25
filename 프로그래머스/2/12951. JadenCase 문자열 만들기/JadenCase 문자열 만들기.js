function solution(s) {
    let res = s.split(" ").map((word) => {
        return word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
    }).join(" ")
    
    return res
}