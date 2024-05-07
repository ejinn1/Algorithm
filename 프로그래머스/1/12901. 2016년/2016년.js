function solution(a, b) {
    const WEEK = ["SUN", "MON","TUE","WED","THU","FRI","SAT"]
    const day = new Date("2016",a-1,b)
    return WEEK[day.getDay()]
}