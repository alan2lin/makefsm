# 通用状态机代码生成框架

<pre>
<code>
老子曰：“…大方无隅，大器晚成，大音希声，大象无形，道隐无名。”
夫大器晚成者，非晚也。器之形神，已成于始，未现也，晚成者，晚现也。

                                                   --alan2lin 
</code>
</pre>
<pre>
<code>
一个具有活力的设计，不管初始如何粗糙，微小，都包含着完整的特征信息。
就像一棵种子长大到一个参天大树，这个过程自始至终都携带着完整的生命信息，时间所做的，不过是将这些细节依次展开。    

                                                   -- alan2lin
</code>
</pre>

仓库地址:  http://github.com/alan2lin/makefsm  


##Feature
* 提供独立的语法描述状态机。   
* 支持Moore型和Mealy型两种状态机。   
* 代码生成与运行时分离， 支持任意多个 状态机实例 。
* 支持对状态机进行约束性检查，默认检查包含，死状态的检查，状态图的连通性检查。可以扩展自定义的约束性检查(此处尚未做成可扩展的方式)。   
* 支持模板生成，只需要改动模板不需要该动代码即可修改生成内容。
* 支持生成状态图 不需要安装graphviz，纯java版实现。   


##第一章  框架图示

运行时框架
![运行时框架](./document/image/dot/dest/framework.svg "运行时框架")


使用过程
![使用过程](./document/image/dot/dest/rumtime_usage.svg "使用过程")


##第二章 	安装篇:

确保引入 fsm 的runtime包。(todo: 未来考虑发布到maven仓库)。    
定制 状态机， 并按照使用过程进行使用。


##第三章 	定制状态机篇：
诚如demo所见，使用上是比较简单的，只需要按照规定的语法描述状态机就好了。    

以下是对状态机语法规范。（熟悉LL语法的人不妨直接看 gfile目录下的makesm.g文件）。    
语法：状态机描述从句;状态从句;指定开始状态从句;指定结束状态从句;事件从句;   
状态机描述从句格式: 状态机类型  FSM  状态机名称 [ DESC  "状态机的描述"];。   
状态机的类型 有 MOORE 和 MEALY型 。   

状态从句格式: status: 状态名1[/"moore型输出"] [desc "状态描述1"],[状态名2 [desc "状态描述2"]...] ;。   
指定开始状态从句格式:start=状态名;。   
指定结束状态从句格式:end=状态名1[,状态名2...];   
事件从句格式：状态名->状态名\[事件名称[/"mealy型输出"] [DESC "转移事件1"]\];。   

例子语法解析<br/>
MOORE FSM Door  "关于门的状态机生成 详细见 http://www.ibm.com/developerworks/cn/linux/l-fsmachine/index.html ";<br/>
STATUS: opened DESC "打开状态", closed DESC "关闭状态" ,locked "锁定状态" ,unlocked "非锁定状态", end "自定义的结束状态";<br/>
START=opened;<br/>
END=end;<br/>

//为了保证状态机可以退出，避免陷入死循环，增加了个自定义的结束状态，并规定，门在关闭后锁定了才允许离开。<br/>


opened->closed[closeDoor DESC "关门"];<br/>
closed->opened[openDoor DESC "开门"];<br/>
closed->locked[lockDoor DESC "锁门"];<br/>
locked->unlocked[unLockDoor DESC "不锁门"];<br/>
unlocked->locked[lockDoor2 DESC "锁门"];<br/>
unlocked->opened[openDoor2 DESC "解锁后开门"];<br/>
locked->end[finish DESC "完结"];<br/>


##第四章 	乱弹篇

使用状态机的方式可以获得的好处:<br/>
其实,并不存在非得要用状态机的必要情况.只能说当你可以形式化的武器后，你能够确定你所做的事情是正确的。<br/>

*1	使用系统的整体的观点去思考问题。<br/>
使用状态机的模式去思考问题，会强迫设计者必须从全盘去考虑，一步步的将复杂目标系统的状态分解，而不是将整个思路散落于支离破碎的if else中。一个好的具有活力的设计是贯穿系统的整个生命周期的，会跟随着不同的阶段而演化。
一个具有活力的设计，不管初始如何粗糙，微小，都包含着完整的特征信息。<br/>
就像一棵种子长大到一个参天大树，这个过程自始至终都携带着完整的生命信息，时间所做的，不过是将这些细节依次展开。<br/>
一个具有活力的，能够自我保持设计，也如此，在它的开始，就隐含有未来的一切关键特征的元信息，这种信息在初期未必是清晰可见的，<br/>
就像一朵花的形状和香味在它的种子期间就已经决定了，在种子期,你是看不到的，哪怕是用最高端的电子显微镜，但只要经过时间的催化，它们必定按照这种设定的方式演化（按语中的大器晚成即是此意）。
采用状态机的方式，能够在系统演化时提供快速响应和正确的保证。<br/>
*2	在统一的规则作用下，将更多的精力投入到状态响应行为上。<br/>
让实现人员更多的集中在行为的实现上，而不是行为发生序列的控制上。<br/>
*3	具备形式化推导的能力。<br/>
      状态机本身就是一个形式化的工具，系统的状态可以根据输入序列明确的推导出来。另外还可以使用一些数学上的知识来辅助工作，比如本软件的生成全部可能的路径的测试用例，就用了图论相关的知识。<br/>

本软件可能适合的场景:<br/>
*1	交易引擎的处理单元的实现。<br/>
*2	游戏的npc的状态控制。<br/>
*3	其他的...暂时没想到。<br/>



