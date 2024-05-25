function solution(skill, skill_trees) {
    skill_trees = skill_trees.map((skills) => {
        return [...skills].filter((s) => skill.includes(s)).join('')
    })
    
    let res = 0
    skill_trees.forEach((skills) => {
        let tmp = skill.slice(0, skills.length)
        if(tmp === skills) res++
    })
    
    return res
}