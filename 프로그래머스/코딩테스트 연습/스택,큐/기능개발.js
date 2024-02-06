function solution(progresses, speeds) {
  let answer = [0];
  let days = progresses.map((progress, index) =>
    Math.ceil((100 - progress) / speeds[index])
  );

  let maxDay = days[0];
  for (let i = 0; i < days.length; i++) {
    if (days[i] <= maxDay) {
      let tmp = answer.pop();
      answer.push(tmp + 1);
    } else {
      maxDay = days[i];
      answer.push(1);
    }
    console.log(answer);
  }

  return answer;
}
