function solution(files) {
    files = files.map((file) => {
        let head = ''
        let num = ''
        let tail = ''
        let i = 0
        let len = file.length

        while (i < len && isNaN(file[i]) || file[i] === ' ') {
            head += file[i++]
        }

        while (i < len && !isNaN(file[i]) && num.length < 5) {
            num += file[i++]
        }

        if (i < len) {
            tail = file.slice(i)
        }

        return [head, num, tail]
    })
    
    files.sort((a, b) => {
        const headCompare = a[0].toLowerCase().localeCompare(b[0].toLowerCase())
        if (headCompare !== 0) return headCompare
        return parseInt(a[1], 10) - parseInt(b[1], 10)
    });

    
    // console.log(files.map((file) => file.join('')))
    return files.map((file) => file.join(''))
}