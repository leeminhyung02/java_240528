import { useState } from "react";

/*
input태그 2개를 생성

*/
function Input1(){
	let [input, setInput] = useState("");
	let [flag, setFlag] = useState(true);
	let change = e=>setInput(e.target.value);

	// function change(e){
	// 	setInput(e.target.value);
	// }
	let btnclick = ()=>setFlag(!flag);
	return(
		<div>
			<input type="text" disabled={!flag} value={input} onChange={change}/>
			<button onClick={btnclick}>변환</button>
			<input type="text" disabled={flag} value={input} onChange={change}/>

		</div>
	)
}

export default Input1;