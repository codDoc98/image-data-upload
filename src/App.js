import { useState } from "react";
import axios from 'axios';



function App() {
  const [caption, setCaption]=useState("");
  const Image= new FormData();
  let File;

  const onPicSelect=(e)=>{
    e.preventDefault();
    console.log(e);
     File= e.target.files[0];
    Image.append("Image", File);
    console.log(Image.get("Image") )
  }

  const onSubmit=async(e)=>{
    e.preventDefault();
    try{
     //imageData.append("caption", caption);
    let res = await axios.post("http://localhost:8080/image",{Image,caption},{headers:{
      "Content-Type":"multipart/form-data"    }});
    console.log(res);
    }
    catch(e){
      
      console.log(e);
    }
  }
  return (
    <div className="App">
      <header className="App-header">
        <form>
        <label >Create Your Image Gallery</label><br/>
        <input  name="pic" type = "file" accept="image" onChange={(e)=>{onPicSelect(e)}} placeholder="choose image" /><br/><br/>
        <label>Caption</label><br/>
        <input type="text" name= "caption" value={caption} onChange={(e)=> setCaption(e.target.value)}></input><br/><br/>
        <button type="submit" onClick={(e)=>onSubmit(e)} >Submit</button>
        </form>
      </header>
    </div>
  );
}

export default App;
