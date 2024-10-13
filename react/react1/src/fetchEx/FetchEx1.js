
import {useState, useEffect } from 'react';

function FetchEx1(){
	let [str, setStr] = useState('');
	let [obj, setObj] = useState(null);
	let [person, setPerson] = use
	useEffect(()=>{
		fetch('/spring/react/get/str')
			//서버에서 보낸 결과를 문자열로 변환
			.then((res)=>{
				return res.text();
			})
			//.then(res=>res.text())
			.then(data=>setStr(data))
			.catch(error => console.error(error));

		fetch('/spring/react/get/obj')
			//서버에서 보낸 결과를 객체로 변환
			.then(res=>res.json())
			.then(data=>setObj(data))
			.catch(e=>console.error(e));
	},[]);

	function submit(e){
		e.preventDefault();

		//form태그 안에 있는 input태그들 값을 한번에 읽어와서 객체로 넘겨줌
		const data = new FormData(e.target);
		fetch("/spring/react/send/person", {
			method : 'post',
			body : data
			//content-Type이 multipart/form-data 또는 application/x-www-form-urlencoded로 되어 있어서
			//@RequestBody로 바로 받을 수 없음
		})
			.then(res => res.text())
			.then(data => console.log(data))
			.catch(e=>console.error(e));
		
		let obj = {
			name : data.get("name"),
			age : data.get("age")
		}
		fetch("/spring/react/send/person2", {
			method : 'post',
			body : JSON.stringify(obj),
			headers : {
				'Content-Type' : 'application/json'
			}
		})
			.then(res => res.text())
			.then(data => console.log(data))
			.catch(e=>console.error(e));
	}
	return(
		<div>
			<h1>{str}</h1>
			{
				obj && (
					<div>
						<div>이름 : {obj.name}</div>
						<div>나이 : {obj.age}</div>
					</div>
				)
			}
			<form onSubmit={submit}>
				<input name="name" placeholder="이름을 입력하세요"/>
				<br/>
				<input name="age" type="number" placeholder="나이를 입력하세요"/>
				<button type="submit">전송</button>
			</form>
		</div>
	)
}

export default FetchEx1;