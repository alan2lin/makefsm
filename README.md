# 林氏物语.大器晚成之状态机代码生成框架

老子曰：“…大方无隅，大器晚成，大音希声，大象无形，道隐无名。”
夫大器晚成者，非晚也。器之形神，已成于始，未现也，晚成者，晚现也。
                                                   --林氏按语


讨论组地址:  http://groups.google.com/group/antlr_chinese/  <br/>
相关的技术Q群: 281827854

##第一章  前言(略)

##第二章 	安装篇:
1、到http://www.graphviz.org/Download.php    下载一个graphviz ，并安装。<br/>
2、确保你的环境变量 path 中有 dot.exe 所在的路径的配置。检验办法 打开命令行窗口 执行 dot –version, 如果有版本信息输出则说明配置正确。<br/>
3、运行自带的demo ，准备了两个demo，一个是door的，一个是自己随便写的。在后续版本，有时间了会准备一些经典的demo。<br/>
解开压缩包，cd 到该目录，执行命令 <br/>
java -cp makefsm.jar makefsm.Run .\testdata\door.data <br/>
java -cp makefsm.jar makefsm.Run .\testdata\testfsm.data <br/>


##第三章 	使用篇：
诚如demo所见，使用上是比较简单的，只需要按照规定的语法描述状态机就好了。<br/>

以下是对状态机语法规范。（熟悉LL语法的人不妨直接看 gfile目录下的makesm.g文件）。<br/>
语法：状态机描述从句;状态从句;指定开始状态从句;指定结束状态从句;事件从句;<br/>
状态机描述从句格式: 状态机类型  FSM  状态机名称 [ DESC  "状态机的描述"];。<br/>
状态机的类型 有 MOORE 和 MEALY型 。<br/>

状态从句格式: status: 状态名1 [desc "状态描述1"],[状态名2 [desc "状态描述2"]...] ;。<br/>
指定开始状态从句格式:start=状态名;。<br/>
指定结束状态从句格式:end=状态名1[,状态名2...];<br/>
事件从句格式：状态名->状态名\[事件名称 [DESC "转移事件1"]\];。<br/>

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

1	使用系统的整体的观点去思考问题。<br/>
使用状态机的模式去思考问题，会强迫设计者必须从全盘去考虑，一步步的将复杂目标系统的状态分解，而不是将整个思路散落于支离破碎的if else中。一个好的具有活力的设计是贯穿系统的整个生命周期的，会跟随着不同的阶段而演化。
一个具有活力的设计，不管初始如何粗糙，微小，都包含着完整的特征信息。<br/>
就像一棵种子长大到一个参天大树，这个过程自始至终都携带着完整的生命信息，时间所做的，不过是将这些细节依次展开。<br/>
一个具有活力的，能够自我保持设计，也如此，在它的开始，就隐含有未来的一切关键特征的元信息，这种信息在初期未必是清晰可见的，<br/>
就像一朵花的形状和香味在它的种子期间就已经决定了，在种子期,你是看不到的，哪怕是用最高端的电子显微镜，但只要经过时间的催化，它们必定按照这种设定的方式演化（按语中的大器晚成即是此意）。
采用状态机的方式，能够在系统演化时提供快速响应和正确的保证。<br/>
2	在统一的规则作用下，将更多的精力投入到状态响应行为上。<br/>
让实现人员更多的集中在行为的实现上，而不是行为发生序列的控制上。<br/>
3	具备形式化推导的能力。<br/>
      状态机本身就是一个形式化的工具，系统的状态可以根据输入序列明确的推导出来。另外还可以使用一些数学上的知识来辅助工作，比如本软件的生成全部可能的路径的测试用例，就用了图论相关的知识。<br/>

本软件可能适合的场景:<br/>
1	交易引擎的处理单元的实现。<br/>
2	游戏的npc的状态控制。<br/>
3	其他的...暂时没想到。<br/>


##第五章 	引用
关于源码的使用，推荐使用带antlr插件的eclipse编译，环境搭建，请参见<br/>
(http://code.google.com/p/antlr-demo/downloads/list)
