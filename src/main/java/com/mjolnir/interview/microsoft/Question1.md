题目描述:

有两个人玩一个游戏，给定一个最大可取整数 maxChoosableInteger，两个人轮流从1~maxChoosableInteger 中取一个数，取过的数不可再取，

若其中一方取过以后，所有取过的数加起来的和大于等于desiredTotal，那么这个人获胜。

现在给你maxChoosableInteger和desiredTotal，问先手是否必胜，假定游戏双方均采取最优策略。

你可以假定给出的 maxChoosableInteger不超过20,desiredTotal不超过300。

样例

输入:
maxChoosableInteger = 10
desiredTotal = 11

输出:
false


points:

我们读完题发现这题似乎是一题经典的博弈问题，但是有一个很重要的限制条件————每个数只能取一次。

有了这个条件，我们很容易就能想到所有的取数方案，最多有 maxChoosableInteger! 种，即 1~maxChoosableInteger 的全排列。

但是一一枚举这maxChoosableInteger!种方案明显超过了能承受的时间复杂度。

1.前缀和的思想:计算1~n的前缀和，只要计算出1~n-1的前缀和再加上n即可，避免了多余的计算。

2.记忆化搜索:和前缀和不同的是，这里用的是自顶向下(类似于分治的把大问题拆分为小问题的求解方法)的求解方法。



