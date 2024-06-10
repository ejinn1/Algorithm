function solution(skill, skill_trees) {
    skill_trees = skill_trees.map((trees) => {
        return [...trees].filter((tree) => skill.indexOf(tree) !== -1).join('')
    })
    
    let res = 0
    skill_trees.forEach((trees) => {
        let tmp = skill.slice(0, trees.length)
        if(tmp === trees) res++
    })
    
    return res
}