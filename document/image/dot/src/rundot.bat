

for /R %%s in (*.dot) do (
 dot -Tsvg %%s   -o..\dest\%%~ns.svg
rem dot -Tpng -Gdpi=300  %%s   -o..\dest\%%~ns.png
)

..\dest\framework.svg
rem ..\dest\rumtime_usage.svg