package practice.leetcode

fun main(){
    println(validAnagram1("anagram","nagaram"))
}

private fun validAnagram(s:String, t:String):Boolean{
    val sMappings = HashMap<Char,Int>()
    val tMappings = HashMap<Char,Int>()
    if(s.length != t.length){
        return false
    }

    for(i in 0..s.lastIndex){
        sMappings[s[i]] = sMappings.getOrDefault(s[i],0) + 1
        tMappings[t[i]] = tMappings.getOrDefault(t[i],0) + 1
    }

    for(key in sMappings.keys){
        if(!tMappings.containsKey(key) || tMappings[key] != sMappings[key] ){
            return false
        }
    }

    return true
}
private fun validAnagram1(s:String, t:String):Boolean{
  return s.toCharArray().sorted() == t.toCharArray().sorted()
}